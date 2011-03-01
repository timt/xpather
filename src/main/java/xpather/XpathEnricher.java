package xpather;

public interface XpathEnricher<T extends XpathFragment> {
    T enrich(XpathFragment xpathFragment);
}
