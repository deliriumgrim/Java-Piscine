#1. Make target directory
rm -rf target
mkdir target

#2. Compile ImageToChar:
/home/delirium/.jdks/corretto-1.8.0_332/bin/javac -d ./target src/java/edu/school21/printer/*/*.java

#3. Copy resources
cp -R src/resources target

#4. Create jar archive
/home/delirium/.jdks/corretto-1.8.0_332/bin/jar cfm target/image-to-chars-printer.jar src/manifest.txt -C target/ .

#5. Run
/home/delirium/.jdks/corretto-1.8.0_332/bin/java -jar "target/image-to-chars-printer.jar" . o