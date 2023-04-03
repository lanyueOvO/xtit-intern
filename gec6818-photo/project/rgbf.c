#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <stdio.h>

#define BUFSIZE 800*480*4
int rgb(int x,int y);
int main()
{
	rgb(800,480);
	return 0 ;
}

int rgb(int x, int y)
{
	int fd = open("/dev/fb0",O_RDWR);

    int *plcd = (int*)mmap(NULL, BUFSIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    // int x, y;
	for(int j=0; y<j; j++) 
	{
		for(int i=0; x<i; i++) 
		{
			// *(plcd + 800*y + x) = 0xff00;
            if (y<600)
            {
                *(plcd + 600*y + x) = 0x00FFFF00;
            }
            
		}
	}
    munmap(plcd, BUFSIZE);
	
	close(fd);
}