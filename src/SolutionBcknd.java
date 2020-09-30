public class SolutionBcknd {
    private void GCF_Cancel(Answer ans){
        ans.answer_num= ans.answer_num/ ans.gcf;
        ans.answer_denom= ans.answer_denom/ans.gcf;
        if(ans.answer_denom<0){ans.answer_denom*=-1; ans.answer_num*=-1;}
    }
    private int GCF(int numer, int denom){
        if(denom !=0){
            return GCF(denom, numer%denom);
        }
        return numer;
    }
    public boolean errorcheck(int denom){
        return denom != 0;
    }
    public String print_mixed(Answer ans){
        int wholenum = ans.answer_num/ans.answer_denom;
        return (wholenum+" "+Math.abs(ans.answer_num-wholenum*ans.answer_denom)+"/"+ans.answer_denom);
    }
    public Answer mult_main(int numer1, int denom1, int numer2, int denom2, String Operation){
        Answer ans;
        if(Operation.equals("/")) {
            ans = new Answer(numer1 * denom2, denom1 * numer2, errorcheck(denom1 * numer2),1);
        }
        else {
            ans = new Answer(numer1 * numer2, denom1 * denom2, errorcheck(denom1 * denom2),1);
        }
        if(ans.answer_num!=1&&ans.answer_denom!=1&&ans.answer_num!=0&& ans.answer_valid){
            ans.gcf = GCF(Math.abs(ans.answer_num),Math.abs(ans.answer_denom));
            GCF_Cancel(ans);
        }
        return ans;
    }
}