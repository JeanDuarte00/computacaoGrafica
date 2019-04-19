package miniGame.model.enums;


    public enum Colors{
        VERDE(0.33f,0.42f,0.18f),
        VERMELHO(1.0f,0.3f,0.2f),
        AZUL(0.39f,0.58f,0.93f),
        LARANJA(1.0f, 0.5f, 0.0f);

        private float r;
        private float g;
        private float b;

        Colors(float r, float g, float b){
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public float getR(){
            return this.r;
        }

        public float getG(){
            return this.g;
        }
        public float getB(){
            return this.b;
        }
    }

