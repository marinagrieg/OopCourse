package ru.academits.grigoryeva.range.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        double intersectionFrom = Math.max(this.from, range.from);
        double intersectionTo = Math.min(this.to, range.to);

        if (intersectionTo > intersectionFrom) {
            return new Range(intersectionFrom, intersectionTo);
        }

        return null;
    }
}
