#include <iostream> 
using namespace std;

//si int, ax->eax (32b)
//si int->long, ax->rax (64b)

int main(int argc, char ** argv) {
	short a = 4; 
	short b = 3;
	__asm{
		mov ax, a;
		mov bx, b;
		add ax, bx;
		mov a, ax;
	};
	cout << a << " " << b << endl; 
}