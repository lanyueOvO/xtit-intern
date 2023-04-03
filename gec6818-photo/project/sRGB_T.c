#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

#include <stdio.h>
// #include <sys/mman.h>
 
int main(){
    // system("color f5");
    // int rgb = 0x00ff0000;
    // printf("%d",rgb);

    int fd = open("/dev/fb0",O_RDWR);
	
// 	int *p = mmap(NULL,800*480*4,PROT_READ | PROT_WRITE ,MAP_SHARED , fd , 0);

//     int x,y;
//     for(x=0;x<800;x++)
//         *(p + 800*y + x) = 0x0000ff00;
//     close(fd);
//     munmap(p,800*480*4);

	// for(x=0;x<800;x++)
	// 	for(y=0;y<480;y++)
	// 		if(y<160)
	// 			*(p + 800*y + x) = 0x0000ff00;
	// 		else if(y<320)
	// 			*(p + 800*y + x) = 0x000000ff;
	// 		else
	// 			*(p + 800*y + x) = 0x00ff0000;


    int a[480][800];
	int i,j;

    for(i=0;i<480;i++)
        for (j=0;j<800;j++)
            a[i][j] = 0x00CCE5FF;
        if (i<169)
            a[i][j] = 0x000000ff;
        
    write(fd,a,800*480*4);
    close(fd);
 }

