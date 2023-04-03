#include "input.h"


int input_init()
{
    
    int fd_i = open("/dev/input/event0", O_RDWR);
    if(fd_i == -1)
    {
        perror("open event0 failed\n");
    }
}


void input_end(int fd_i)
{
    close(fd_i);
}


int get_touch()
{
    int fd = input_init();

    struct input_event ev;
    int x, y; 
    int x0=-1, y0=-1; 
    while(1)
    {
        int ret = read(fd, &ev, sizeof(ev)); 

        if(ev.type == EV_ABS && ev.code == ABS_X)
        {
            if(x0 == -1)
            {
                x0 = ev.value;
            }
            x = ev.value;
        }
        else if(ev.type == EV_ABS && ev.code == ABS_Y)
        {
            if(y0 == -1)
            {
                y0 = ev.value;
            }
            y = ev.value;
        }
        
        
        if(ev.type == EV_KEY && ev.code == BTN_TOUCH && ev.value == 0)
        {
            break;
        }

		
    }
    

	printf("first:(%d, %d)\n", x0, y0);
	printf("last:(%d, %d)\n", x, y);

	if(x == x0 && y == y0){
		printf("--------click--------!\n");
    	return 0;
	}


	if(abs(y-y0) >= 2*abs(x-x0)){

    	if(y-y0 > 0){
    		
    		printf("--------down--------!\n");
    		return 1;
		}else{
			printf("--------up--------!\n");
    		return 2;
		}
    	
	}else{

		if(x-x0 > 0){
			
			printf("--------right!--------\n");
    		return 3;
		}else{
			
			printf("--------left!--------\n");
    		return 4;
		}
	}


    input_end(fd);
}



