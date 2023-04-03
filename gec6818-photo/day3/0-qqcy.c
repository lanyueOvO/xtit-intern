#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/mman.h>

#define BUFSIZE 800*480*4 // 宏定义 只是简单的文本替换

int main()
{
	// 1.打开文件
	int fd = open("/dev/fb0", O_RDWR);
	if(fd == -1)
	{
		perror("open fb0 failed\n");
		return 0;
	}
	
	// 2.进行映射
	int *plcd = mmap(NULL, BUFSIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	if(plcd == NULL)
	{
		perror("mmap failed\n");
	}
	
	// 3.对指针进行操作 《==》 对地址进行操纵 《==》对像素点进行操作
	int x, y;
	for(y=0; y<480; y++) // 第几行
	{
		for(x=0; x<800; x++) // 该行的第几个
		{
			*(plcd + 800*y + x) = 0xff00;
		}
	}
	
	/*
		// 3.把颜色值写到帧缓冲文件中
		int ret = write(fd, color_buf, BUFSIZE);
		if(ret == -1)
		{
			perror("write color failed\n");
		}
	*/
	// 解映射
	munmap(plcd, BUFSIZE);
	
	// 4.关闭文件
	close(fd);
	
	return 0;
}





