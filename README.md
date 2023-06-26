# ajcwovenissue
Intermittent issue when running weaving with aspectj.

Here we are going to create files using ksp as add `@Step` annotation to them.
I thought the issue was caused by the number of weave point. It is not. Even with just single weave point, it will fail eventually.

How to trigger:

`for i in {1..50}; do echo "Command no. $i"; mvn -Dmaven.test.skip.exec=true package; done`

Sample error:
```
---- AspectJ Properties ---
AspectJ Compiler 1.9.19 built on Wednesday Dec 21, 2022 at 06:57:22 PST
---- Dump Properties ---
Dump file: ajcore.20230622.091106.735.txt
Dump reason: java.lang.RuntimeException
Dump on exception: true
Dump at exit condition: abort
---- Exception Information ---
java.lang.RuntimeException: key not found in wovenClassFile
	at org.aspectj.weaver.WeaverStateInfo.findEndOfKey(WeaverStateInfo.java:431)
	at org.aspectj.weaver.WeaverStateInfo.replaceKeyWithDiff(WeaverStateInfo.java:387)
	at org.aspectj.weaver.bcel.LazyClassGen.getJavaClassBytesIncludingReweavable(LazyClassGen.java:768)
	at org.aspectj.weaver.bcel.BcelWeaver.getClassFilesFor(BcelWeaver.java:1459)
	at org.aspectj.weaver.bcel.BcelWeaver.weaveAndNotify(BcelWeaver.java:1421)
	at org.aspectj.weaver.bcel.BcelWeaver.weave(BcelWeaver.java:1192)
	at org.aspectj.ajdt.internal.compiler.AjPipeliningCompilerAdapter.weaveQueuedEntries(AjPipeliningCompilerAdapter.java:510)
	at org.aspectj.ajdt.internal.compiler.AjPipeliningCompilerAdapter.afterCompiling(AjPipeliningCompilerAdapter.java:374)
	at org.aspectj.ajdt.internal.compiler.CompilerAdapter.ajc$afterReturning$org_aspectj_ajdt_internal_compiler_CompilerAdapter$2$f9cc9ca0(CompilerAdapter.aj:79)
	at org.aspectj.org.eclipse.jdt.internal.compiler.Compiler.compile(Compiler.java:428)
	at org.aspectj.ajdt.internal.core.builder.AjBuildManager.performCompilation(AjBuildManager.java:1101)
	at org.aspectj.ajdt.internal.core.builder.AjBuildManager.performBuild(AjBuildManager.java:275)
	at org.aspectj.ajdt.internal.core.builder.AjBuildManager.batchBuild(AjBuildManager.java:188)
	at org.aspectj.ajdt.ajc.AjdtCommand.doCommand(AjdtCommand.java:103)
	at org.aspectj.ajdt.ajc.AjdtCommand.runCommand(AjdtCommand.java:47)
	at org.aspectj.tools.ajc.Main.run(Main.java:374)
	at org.aspectj.tools.ajc.Main.runMain(Main.java:253)
	at org.codehaus.mojo.aspectj.AbstractAjcCompiler.execute(AbstractAjcCompiler.java:620)
	at org.codehaus.mojo.aspectj.AjcTestCompileMojo.execute(AjcTestCompileMojo.java:106)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:126)
	at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2(MojoExecutor.java:342)
	at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute(MojoExecutor.java:330)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:213)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:175)
	at org.apache.maven.lifecycle.internal.MojoExecutor.access$000(MojoExecutor.java:76)
	at org.apache.maven.lifecycle.internal.MojoExecutor$1.run(MojoExecutor.java:163)
	at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute(DefaultMojosExecutionStrategy.java:39)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:160)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:105)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:73)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:53)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:118)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:261)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:173)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:101)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:910)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:283)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:206)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)
	at java.base/java.lang.reflect.Method.invoke(Method.java:578)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:283)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:226)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:407)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:348)
  
....


weaveinfo Join point 'method-execution(com.app.Animal com.app.Animal1FactoryKt.Animal1Factory(com.app.Animal1Type))' in Type 'com.app.Animal1FactoryKt' (Animal1Factory.kt) advised by before advice from 'io.qameta.allure.aspects.StepsAspects' (allure-java-commons-2.20.1.jar!StepsAspects.class(from StepsAspects.java))
weaveinfo Join point 'method-execution(com.app.Animal com.app.Animal1FactoryKt.Animal1Factory(com.app.Animal1Type))' in Type 'com.app.Animal1FactoryKt' (Animal1Factory.kt) advised by afterThrowing advice from 'io.qameta.allure.aspects.StepsAspects' (allure-java-commons-2.20.1.jar!StepsAspects.class(from StepsAspects.java))
weaveinfo Join point 'method-execution(com.app.Animal com.app.Animal1FactoryKt.Animal1Factory(com.app.Animal1Type))' in Type 'com.app.Animal1FactoryKt' (Animal1Factory.kt) advised by afterReturning advice from 'io.qameta.allure.aspects.StepsAspects' (allure-java-commons-2.20.1.jar!StepsAspects.class(from StepsAspects.java))
abort ABORT -- (RuntimeException) key not found in wovenClassFile
key not found in wovenClassFile
java.lang.RuntimeException: key not found in wovenClassFile
	at org.aspectj.weaver.WeaverStateInfo.findEndOfKey(WeaverStateInfo.java:431)
	at org.aspectj.weaver.WeaverStateInfo.replaceKeyWithDiff(WeaverStateInfo.java:387)
	...

```
