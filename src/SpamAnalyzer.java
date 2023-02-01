class SpamAnalyzer extends KeywordAnalyzer {
    private String[] spamKeywords;
    
    public SpamAnalyzer(String[] spamKeywords) {
    this.spamKeywords = spamKeywords;
    }

    @Override
    protected String[] getKeywords() {
        return spamKeywords;
    }
        
    @Override
    protected Label getLabel(String text) {
            for ( String keyword : getKeywords()) {
                if (text.contains(keyword))
                return Label.SPAM;
            }
            return Label.OK;
            }

    @Override
    public Label processText(String text) {
        return getLabel(text);
    }
}
