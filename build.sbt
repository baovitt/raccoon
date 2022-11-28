import scala.sys.process._

scalaVersion := "3.2.0"

name := "scala-3-native-zio-2"

enablePlugins(ScalaNativePlugin)

nativeConfig ~= { _.withTargetTriple("i386-x86-64-elf") }

nativeConfig ~= { c =>
  c.withCompileOptions(c.compileOptions ++ Seq("-nostdlib", "-nostdinc", "-fno-builtin", "-ffreestanding", "-m32"))
}

nativeConfig ~= { c =>
  c.withLinkingOptions(c.linkingOptions ++ Seq("-fuse-ld=lld", "-m elf_i386"))
}

lazy val make = taskKey[Unit]("Building native components")

make := {
  "make" !
}

resolvers += Resolver.sonatypeRepo("snapshots")

nativeLinkingOptions := Seq("-L" ++ baseDirectory.value.getAbsolutePath() ++ "/target")

nativeLinkStubs := true

compile in Compile := (compile in Compile dependsOn make).value

libraryDependencies += "dev.zio" %%% "zio" % "2.0.1"

// https://mvnrepository.com/artifact/dev.zio/zio-optics
libraryDependencies += "dev.zio" % "zio-optics_native0.4_2.13" % "2.0.0-RC4"

// https://mvnrepository.com/artifact/com.softwaremill.magnolia1_2/magnolia
libraryDependencies += "com.softwaremill.magnolia1_2" % "magnolia_native0.4_2.13" % "1.1.2"

// This is needed for the linking step
libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.4.0"
