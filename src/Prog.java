    class Prog {
        public static void main(String[] args) {
            NegativeTextAnalyzer a = new NegativeTextAnalyzer();
            SpamAnalyzer s = new SpamAnalyzer(new String[]{"купить", "продать"});
            TooLongTextAnalyzer l = new TooLongTextAnalyzer(15);
        
            TextAnalyzer[] T = {a, s, l};
            System.out.println(checkLabels(T, "Эта строка не пройдёт проверку на длину в 3-м по счету анализаторе"));
            System.out.println(checkLabels(T, "Реклама. Предлагаем купить квартиру! (2-й анализатор ругнётся)"));
            System.out.println(checkLabels(T, "Не грусти :(, мышкой похрусти! (1-й)"));
            System.out.println(checkLabels(T, "Здесь всё ОК"));
        }
            
            public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
                for(TextAnalyzer analyzer: analyzers) {
                     if(analyzer.processText(text) != Label.OK) return analyzer.processText(text);
                }
                 return Label.OK;
             }
        }