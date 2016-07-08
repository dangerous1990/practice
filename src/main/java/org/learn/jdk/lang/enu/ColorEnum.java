package org.learn.jdk.lang.enu;

public enum ColorEnum {
    green("绿色") {
        
        @Override
        public
        String getName() {
            return this.name;
        }
    },
    red("红色") {
        
        @Override
        public
        String getName() {
            return this.name;
        }
    },
    blue("蓝色") {
        
        @Override
        public
        String getName() {
            return this.name;
        }
    },
    white("白色") {
        
        @Override
        public
        String getName() {
            return this.name;
        }
    };
    
    protected String name;
    
    private ColorEnum(String value) {
        this.name = value;
    }
    
     public abstract String getName();
}
