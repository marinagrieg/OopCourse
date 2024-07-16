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
            return new Range[]{this, range};
        }

        double unionFrom = Math.min(from, range.from);
        double unionTo = Math.max(to, range.to);

        return new Range[]{new Range(unionFrom, unionTo)};
    }

    public Range[] getDifference(Range range) {
        Range intersection = getIntersection(range);

        if (intersection == null) {
            return new Range[]{new Range(from, to)};
        }

        if (to == intersection.to && from == intersection.from) {
            return null;
        }

        Range[] differenceTemp = new Range[2];
        int rangesCount = 0;

        if (from < intersection.from) {
            differenceTemp[rangesCount] = new Range(from, intersection.from);
            rangesCount++;
        }

        if (to > intersection.to) {
            differenceTemp[rangesCount] = new Range(intersection.to, to);
            rangesCount++;
        }

        Range[] difference = new Range[rangesCount];
        System.arraycopy(differenceTemp, 0, difference, 0, rangesCount);

        return difference;
    }

    public String toString() {
        return STR."от \{from} до \{to}";
    }
}
