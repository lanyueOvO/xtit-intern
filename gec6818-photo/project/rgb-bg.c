#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>

#define BUFSIZE 800*480*4 // 宏定义 只是简单的文本替换

int main()
{

	int fd = open("/dev/fb0", O_RDWR);
	if(fd == -1)
	{
		perror("open fb0 failed\n");
		return 0;
	}
	
	int *plcd = mmap(NULL, BUFSIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	if(plcd == NULL)
	{
		perror("mmap failed\n");
	}
	

	int x, y;
	for(y=0; y<480; y++) 
	{
		for(x=0; x<800; x++) 
		{
			// *(plcd + 800*y + x) = 0xff00;
			if (y<200)
			{
				*(plcd + 600*y + x) = 0x00FFFF00;
			}
			if (x<200)
			{
				*(plcd + 600*y + x) = 0x00FFFF00;
			}
			
		}
	}
	

	// 解映射
	munmap(plcd, BUFSIZE);
	
	close(fd);
	
	return 0;
}