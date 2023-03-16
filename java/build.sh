#!/bin/bash
mkdir -p build && cd build
cp ../test_framework/console_color* ./
jar cf test_framework.jar ../test_framework
jar cf generic_types.jar ../generic_types
javac -Xlint:unchecked -classpath generic_types.jar:test_framework.jar -d ./ ../${1}
