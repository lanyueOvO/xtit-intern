#include "lcd.h"
#include "input.h"


int main()
{
    int fd_lcd = lcd_init();
//
    
	while(1){
		int n = get_touch();
	restart();
	if(n == 0){
		draw_rectangle(120, 120, 200, 200, 0xFAEBD7);
	}
	if(n == 1){
		draw_rectangle(120, 120, 200, 200, 0xF0FFFF);
	}
	if(n == 2){
		draw_rectangle(120, 120, 200, 200, 0x00800080);
	}
	if(n == 3){
		draw_rectangle(120, 120, 200, 200, 0x000000ff);
	}
	if(n == 4){
		draw_rectangle(120, 120, 200, 200, 0x0000ff00);
	}
	}

    lcd_end(fd_lcd);
	

	return 0;
}






