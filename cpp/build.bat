@echo off

call "C:\Program Files (x86)\Microsoft Visual Studio\2017\Community\VC\Auxiliary\Build\vcvarsall.bat" amd64

mkdir build
pushd build
cl /Zi /EHsc /I ..\generic_types\ /I ..\test_framework\ ..\epi\anagrams.cc
popd 
