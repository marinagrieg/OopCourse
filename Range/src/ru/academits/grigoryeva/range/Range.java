package ru.academits.grigoryeva.range;

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
        double intersectionFrom = Math.max(from, range.from);
        double intersectionTo = Math.min(to, range.to);

        if (intersectionTo > intersectionFrom) {
            return new Range(intersectionFrom, intersectionTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || from > range.to) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        double unionFrom = Math.min(from, range.from);
        double unionTo = Math.max(to, range.to);

        return new Range[]{new Range(unionFrom, unionTo)};
    }

    public Range[] getDifference(Range range) {
        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }

        if (to < range.from || from > range.to) {
            return new Range[]{new Range(from, to)};
        }

        int size = 0;

        if (from < range.from) {
            size++;
        }

        if (to > range.to) {
            size++;
        }

        Range[] difference = new Range[size];
        int index = 0;

        if (from < range.from) {
            difference[index++] = new Range (from, range.from);
        }

        if (to > range.to) {
            difference[index] = new Range (range.to, to);
        }

        return difference;
    }

    @Override
    public String toString() {
        return String.format("(%.1f; %.1f)", from, to);
    }
}
