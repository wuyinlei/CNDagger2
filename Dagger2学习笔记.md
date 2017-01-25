# Dagger2学习笔记

标签（空格分隔）： 第三方框架

---

###如何依赖使用
#####第一步
在Project的build.gradle中添加
```
 dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' //添加apt命令

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
```
###第二步
在module（app）中的build.gradle中添加
```
apply plugin: 'android-apt'//(添加到第二行就行)
```

```
dependencies {
  //dagger2
    apt 'com.google.dagger:dagger-compiler:2.0.2' //指定注解处理器
    compile 'com.google.dagger:dagger:2.0.2'  //dagger公用api
    provided 'org.glassfish:javax.annotation:10.0-b28'  //添加android缺失的部分javax注解
}
```

###简单介绍

#####@inject 
通常在需要依赖的地方使用这个注解。换句话说。你用它告诉Dagger2这个类或者字段需要依赖注入。这样Dagger2就会构造一个这个类的实例并满足他们的依赖
#####@Module
Modules类里面的方法专门提供依赖，所以我们定义一个类，用@Module注解，这样Dagger在构造类的实例的时候，就知道从哪里找到需要的依赖，modules的一个重要特征是他们设计为分区并组合在一起（比如说我们的app中可以有多个组成在一起的modules)
#####@Provide
在modules，我们定义的方法使用这个注解，以此来告诉Dagger我们想要构造对象并提供这些依赖
#####@Component
Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，他的主要作用就是连接这两个部分，Components可以提供所有定义了的类型的实例，比如：我们必须用@Component注解一个借口然后列出所有的

###限定符
#####@Qualifier
主要用来区分不同对象实例
首先这个需要去自己定义一个
```

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Debug {

}

```
然后在module里面这样使用(确保使用的@Debug和自己定义的类名是一样的(不是类名  类似于一个接口的自定义注解))
```
    @Provides
    @Debug
    public ApiServer provideApiServerForDebug(OkHttpClient client){
        Log.d("UserModule", "provideApiServerForDebug");
        return new ApiServer(client);
    }
```
最后在Activity或者Fragment或者Presenter里面这样使用(  @Debug确保一致)
```
    @Inject
    @Debug
    ApiServer mApiServerDebug;
```
#####@Named
其实是@Qualifier的一种实现
首先在module里面 使用@Named限定符限定(里面定义好限定key值)
```
  @Provides
    @Named("release")
    public ApiServer provideApiServerForRelease(OkHttpClient client){
        Log.d("UserModule", "provideApiServerForRelease");
        return new ApiServer(client);
    }
```
然后在Activity或者Fragment或者Presenter里面使用的时候也使用相同的限定符，并且保证key值一样，才能达到效果。
```
    @Inject
    @Named("release")
    ApiServer mApiServerRelease;
```

###单例
#####@Singleton
在module里面 也就是提供实例的方法上加入@Singleton
```
  @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }
```
然后在Component的类上面加入@Singleton（确保这俩个地方都要加入，要不然会报错的）
```

@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    void inject(MainActivity activity);

}
```

例子
```
    @Inject
    OkHttpClient mOkHttpClientDemo1;
    @Inject
    OkHttpClient mOkHttpClientDemo2;
```
我们看下输出：
```
01-24 23:27:50.640 26451-26451/ruolan.com.cndagger2 D/MainActivity: mOkHttpClientDemo1:okhttp3.OkHttpClient@64cbd28
01-24 23:27:50.641 26451-26451/ruolan.com.cndagger2 D/MainActivity: mOkHttpClientDemo2:okhttp3.OkHttpClient@64cbd28
```
可以看出来，虽然我们创建两个两个实例，但是这两个实例指向的是同一个地址，也就是说他俩是同一个对象，这也就是单例的实现。

###注意事项（重要）
#####第一条
component的inject方法接收父类型参数，而调用时传入的子类型的对象则无法实行注入
#####第二条
component关联modules中不能有重复的provide
#####第三条
module的provide方法使用了scope，那么component就必须使用同一个注解(比如module使用了@Singleton，那么component也一样要使用)
#####第四条
module的provide方法没有使用scope，那么component和module是否添加注解都无关紧要，可以通过编译
#####第五条
component的dependencies与component自身的scope不能相同，即组件之间的scope不同
#####第六条
Singleton的组件不能依赖其他scope的组件，只能其他scope的组件依赖Singleton的组件
#####第七条
没有scope的component不能依赖有scope的component
#####第八条
一个component不能同时又多个scope（Subcomponent除外）
#####第九条
@Singleton的生命周期依附于component，同一个module provide singleton 不同component也是不一样的




