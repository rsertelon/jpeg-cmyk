## JPEG CMYK

This project adds support for JPEG CMYK on the Java platform.

Originally, it was written by Werner Randelshofer. As he decided to license his work under the Creative Commons By 3.0, I wanted to create a Maven artifact for users of this library, and even enhance it a bit.

## Usage

Add the dependency to your project:

```xml
<!-- Repository -->
<repositories>
    <repository>
        <id>bluepyth</id>
        <name>BluePyth Repository</name>
        <url>http://repository.bluepyth.fr/content/groups/public</url>
    </repository>
</repositories>

<!-- Dependency -->
<dependency>
    <groupId>ch.randelshofer.media</groupId>
    <artifactId>jpeg-cmyk</artifactId>
    <version>1.0.0</version>
</dependency>
```

This will add support for reading CMYK JPEG with Java ImageIO. However, as there are now two JPEG readers you have to read images like so:

```java
// Read an image from a File
BufferedImage imgFromFile = CMYKReader.read(File imageFile); // throws FileNotFoundException, IOException

// Read an image from an ImageInputStream
BufferedImage imgFromImageInputStream = CMYKReader.read(ImageInputStream iis);

// Read an image from an InputStream
BufferedImage imgFromInputStream = CMYKReader.read(InputStream is); // throws IOException
```

If you want to use this library inside a web application project, you should use the provided ContextListener. It will ensure that the library will be loaded by the JDK.

```xml
<?xml version="1.0"?>
<web-app>
	<!-- ... -->
	<listener>
		<listener-class>ch.randelshofer.media.IIOProviderContextListener</listener-class>
	</listener>
	<!-- ... -->
</web-app>

```

## Licence

Copyright Werner Randelshofer 2013

This software is licenced under the Creative Commons By 3.0, you can find more information in the `LICENSE.md` file.
