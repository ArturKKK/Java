class TooLongTextAnalyzer implements TextAnalyzer{
    private int maxLength;
    
    public TooLongTextAnalyzer(int maxLength){
        this.maxLength = maxLength;
    }
    public int getLength() {
        return maxLength;
    }
    public Label processText(String text) {
        if (text.length() < getLength())
        return Label.OK;
        else return Label.TOO_LONG;    
    }
}
