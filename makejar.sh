#!/bin/sh

rm -rf bin
javac src/connect_four/*.java -d bin
jar cvfm connect_four.jar ./src/META-INF/MANIFEST.MF -C ./bin/ .
cat stub.sh connect_four.jar > connect_four.run && chmod +x connect_four.run