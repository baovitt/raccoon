all :
	clang -c src/main/c/add.c -o target/libadd.so -m32 -nostdlib -nostdinc -fno-builtin -ffreestanding -target i386-elf:x86-64