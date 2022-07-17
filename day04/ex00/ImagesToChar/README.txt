#1. Make target directory
rm -rf target
mkdir target

#2. Compile ImageToChar:
/home/delirium/.jdks/corretto-1.8.0_332/bin/javac -d ./target src/java/edu/school21/printer/*/*.java

#3. Run
/home/delirium/.jdks/corretto-1.8.0_332/bin/java -classpath target edu.school21.printer.app.Program o . /home/delirium/Downloads/it