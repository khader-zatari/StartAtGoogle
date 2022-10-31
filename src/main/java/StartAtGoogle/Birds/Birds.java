package StartAtGoogle.Birds;

public enum Birds {
    AMERICAN_GOLDFINCH("Spinus tristis") {
        @Override
        public void sign() {
            System.out.println("Pa-chip-chip-chip-per-chick-a-ree-po-ta-to-chip");
        }
    },
    AMERICAN_ROBIN("Turdus migratorius") {
        @Override
        public void sign() {
            System.out.println("cheer-up;cheer-a-lee;cheer-ee-o,whinny");
        }
    },
    ASIAN_KOEL("Eudynamys scolopaceus") {
        @Override
        public void sign() {
            System.out.println("Koo-Ooo");
        }
    },
    ATLANTIC_PUFFIN("Purr") {
        @Override
        public void sign() {
            System.out.println(this.scientificName);
        }
    };

    Birds(String scientificName) {
        this.scientificName = scientificName;
    }

    public final String scientificName;


    public abstract void sign();
}
