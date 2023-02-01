class NegativeTextAnalyzer extends KeywordAnalyzer {
    
    private String[] arrNegative;
    
    public NegativeTextAnalyzer(){
        this.arrNegative = new String[3];
        arrNegative[0] =  ":(";
        arrNegative[1] = "=(";
        arrNegative[2] = ":|";
    }

    @Override
    protected String[] getKeywords() {
        return arrNegative;
    }

    @Override
    protected Label getLabel(String text) {
        for ( String keyword : getKeywords()) {
            if (text.contains(keyword))
            return Label.NEGATIVE_TEXT;
        }
        return Label.OK;
        }

    @Override
    public Label processText(String text) {
        return getLabel(text);
    }
}
