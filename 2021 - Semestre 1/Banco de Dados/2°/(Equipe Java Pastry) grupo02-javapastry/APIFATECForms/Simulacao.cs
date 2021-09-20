using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Runtime.InteropServices;
using System.Windows.Forms;

namespace APIFATECForms
{
    class Simulacao
    {
        private const int MOUSEEVENTF_WHEEL = 0x0800;
        private const int MOUSEEVENTF_LEFTDOWN = 0x02;
        private const int MOUSEEVENTF_LEFTUP = 0x04;
        private const int MOUSEEVENTF_RIGHTDOWN = 0x08;
        private const int MOUSEEVENTF_RIGHTUP = 0x10;

        private Image gifImage;
        private FrameDimension dimension;
        private int frameCount;
        private int currentFrame = -1;
        private bool reverse;
        private int step = 1;

        [System.Runtime.InteropServices.DllImport("user32.dll")] // simulacao do cursor do mouse para renderizar o mapa
        static extern bool SetCursorPos(int x, int y);

        [DllImport("user32.dll", CharSet = CharSet.Auto, CallingConvention = CallingConvention.StdCall)] // simulacao do mouse para renderizar o mapa

        public static extern void mouse_event(int dwFlags, int dx, int dy, int cButtons, int dwExtraInfo);

        bool StatusMouse = false;

        public bool DoScrowMouseBack(int xpos, int ypos)
        {
            Cursor.Position = new Point(xpos, ypos); // pego a posicao do mouse e atribuo a uma nova posicao

            SetCursorPos(xpos, ypos); // defino a posicao do cursor de acordo com os parametros definidos na funcao

            try
            {
                mouse_event(MOUSEEVENTF_WHEEL, xpos, ypos, -1, 0); // gira para tras
                StatusMouse = true;
                //sfMap1.Refresh(); // teste
            }
            catch { }

            return StatusMouse;
        }

        public void DoScrowMouseFront(int xpos, int ypos)
        {
            Cursor.Position = new Point(xpos, ypos);
            SetCursorPos(xpos, ypos);

            if (StatusMouse == true)
            {
                try
                {
                    mouse_event(MOUSEEVENTF_WHEEL, xpos, ypos, 1, 0); // gira para tras
                }
                catch { }
            }
        }

        public Simulacao(string path)
        {
            gifImage = Image.FromFile(path);
            //initialize
            dimension = new FrameDimension(gifImage.FrameDimensionsList[0]);
            //gets the GUID
            //total frames in the animation
            frameCount = gifImage.GetFrameCount(dimension);
        }

        public Image GetNextFrame()
        {

            currentFrame += step;

            //if the animation reaches a boundary...
            if (currentFrame >= frameCount || currentFrame < 0)
            {
                if (reverse)
                {
                    step *= -1;
                    //...reverse the count
                    //apply it
                    currentFrame += step;
                }
                else
                {
                    currentFrame = 0;
                    //...or start over
                }
            }
            return GetFrame(currentFrame);
        }

        public Image GetFrame(int index)
        {
            gifImage.SelectActiveFrame(dimension, index);
            //find the frame
            return (Image)gifImage.Clone();
            //return a copy of it
        }

        public bool ReverseAtEnd
        {
            //whether the gif should play backwards when it reaches the end
            get { return reverse; }
            set { reverse = value; }
        }

    }
}
