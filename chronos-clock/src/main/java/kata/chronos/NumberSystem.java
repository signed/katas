package kata.chronos;

public enum NumberSystem {
    Arabic {
        @Override
        public NumberSystem other() {
            return NumberSystem.Roman;
        }
    },
    Roman {
        @Override
        public NumberSystem other() {
            return NumberSystem.Arabic;
        }
    };


    public abstract NumberSystem other();

}
