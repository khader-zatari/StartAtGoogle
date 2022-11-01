package StartAtGoogle.Builder;

import java.time.LocalDate;

class JobPosition {
    private final LocalDate publishDate;
    private final String title;
    private final String description;
    private final String location;
    private final int salaryCap;
    private final boolean isRemote;
    private final String experienceYears;

    static class Builder {
        //Required Parameters
        private final boolean isRemote;
        private final LocalDate publishDate;
        private final String title;

        //Optional Parameters
        private String description;
        private String location = "Tel Aviv";
        private int salaryCap;
        private String experienceYears;

        public Builder(String title, LocalDate publishDate, boolean isRemote) {
            this.title = title;
            this.publishDate = publishDate;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(int salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public Builder experienceYears(String experienceYears) {
            this.experienceYears = experienceYears;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition(Builder builder) {
        this.title = builder.title;
        this.publishDate = builder.publishDate;
        this.isRemote = builder.isRemote;
        this.experienceYears = builder.experienceYears;
        this.salaryCap = builder.salaryCap;
        this.location = builder.location;
        this.description = builder.description;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "publishDate=" + publishDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salaryCap=" + salaryCap +
                ", isRemote=" + isRemote +
                ", experienceYears='" + experienceYears + '\'' +
                '}';
    }
}
