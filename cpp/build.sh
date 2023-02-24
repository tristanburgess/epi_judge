#!/bin/bash
mkdir -p build && cd build
clang++ -std=c++14 -g -pthread -I ../generic_types -I ../test_framework ../${1} -o ./$(basename $1 .cc)
