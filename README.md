Usefull utilities and samples about learning Java and HotSpot VM.

Based on [http://www.docjar.com/html/api/sun/jvm/hotspot/tools/PermStat.java.html][PermStat]

You need to add _sa-jdi.jar_ to your class path. This is generally available in your JDK's lib directory. Also, you might need to run this class with super user privileges in order to access the other JVM.

You can install _sa-jdi.jar_ to your local maven repository if you use [maven][maven].

	```bash
	mvn install:install-file  -Dfile=/usr/local/java/jdk1.7.0_40/lib/sa-jdi.jar \
      -DgroupId=sun.jvm.hotspot \
      -DartifactId=sa-jdi \
      -Dversion=24.0-b56.BuildVersion \
      -Dpackaging=jar \
      -DgeneratePom=true \
      -DcreateChecksum=true
	```

Now, you can add sa-jdi dependency to your pom.xml


	```xml
	<dependency>
        <groupId>sun.jvm.hotspot</groupId>
        <artifactId>sa-jdi</artifactId>
        <version>24.0-b56.BuildVersion</version>
	</dependency>
	```

sa-jdi docs is here: [http://www.docjar.com/docs/api/sun/jvm/hotspot/package-index.html][sa_jdi_doc]

[PermStat]: http://www.docjar.com/html/api/sun/jvm/hotspot/tools/PermStat.java.html "PermStat"

[maven]: http://maven.apache.org/ "maven"

[sa_jdi_doc]: http://www.docjar.com/docs/api/sun/jvm/hotspot/package-index.html "sa-jdi docs"




