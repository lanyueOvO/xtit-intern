#include "lcd.h"

int *plcd = NULL; 

int lcd_init()
{
    
    int fd = open("/dev/fb0", O_RDWR);
	if(fd == -1)
	{
		printf("open fb0 failed\n");
		return 0;
	}
	
	plcd = mmap(NULL, BUFSIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
	if(plcd == NULL)
	{
		printf("mmap failed\n");
	}
    return fd;
}

void lcd_end(int fd)
{
	munmap(plcd, BUFSIZE);
	
	close(fd);
}

void lcd_point_show(int x, int y, int color)
{
    if(x>=0 && x<800 && y>=0 && y<480)
    {
        *(plcd + 800*y + x) = color;
    }
}

void draw_rectangle(int x0, int y0, int h, int w, int color)
{
    int i, j;
    for(i=0; i<h; i++) 
    {
        for(j=0; j<w; j++) 
        {
            lcd_point_show(j+x0, i+y0, color);
        }
    }
}

void draw_circle(int x0, int y0, int r, int color)
{
    int i, j;
    for(i=0; i<480; i++) 
    {
        for(j=0; j<800; j++) 
        {
            if( (j-x0)*(j-x0) + (i-y0)*(i-y0) < r*r )
            {
                lcd_point_show(j, i, color);
            }
        }
    }
}

void float_circle(int r, int size, int color){
	
	while(1){
		restart();
		sleep(1);
		draw_circle(400, 240, r, color);
		sleep(1);
		
		r += size;
		if(r > 240){
			r = 0;
		}
		
	}
	
}


void restart(){
    int i, j;
    for(i=0; i<480; i++) 
    {
        for(j=0; j<800; j++) 
        {
            
        	lcd_point_show(j, i, 0x00f0f0ff);
            
        }
    }
}


