package com.team1.resources;

public enum Cores {
    BLACK {
        @Override
        public String colorir(String texto) {
            return "\u001B[30m" + texto + "\u001B[0m";
        }
    },
    RED {
        @Override
        public String colorir(String texto) {
            return "\u001B[31m" + texto + "\u001B[0m";
        }
    },
    GREEN {
        @Override
        public String colorir(String texto) {
            return "\u001B[32m" + texto + "\u001B[0m";
        }
    },
    YELLOW {
        @Override
        public String colorir(String texto) {
            return "\u001B[33m" + texto + "\u001B[0m";
        }
    },
    BLUE {
        @Override
        public String colorir(String texto) {
            return "\u001B[34m" + texto + "\u001B[0m";
        }
    },
    PURPLE {
        @Override
        public String colorir(String texto) {
            return "\u001B[35m" + texto + "\u001B[0m";
        }
    },
    CYAN {
        @Override
        public String colorir(String texto) {
            return "\u001B[36m" + texto + "\u001B[0m";
        }
    };

    public abstract String colorir(String texto);
}
