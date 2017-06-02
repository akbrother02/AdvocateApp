package loadingdata.ashish.advocateapp.Model;

/**
 * Created by Aashish on 6/1/2017.
 */

public class CasesModel {

    String Casename;
    String status;
    String Casenumber;
    String registerdate;
    String Casetype;

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    String ClientName;
    String Casecharges;
    String Casefees;
    String OpponentName;
    String OpponentLawyer;

    public String getCasename() {
        return Casename;
    }

    public void setCasename(String casename) {
        Casename = casename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCasenumber() {
        return Casenumber;
    }

    public void setCasenumber(String casenumber) {
        Casenumber = casenumber;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public String getCasetype() {
        return Casetype;
    }

    public void setCasetype(String casetype) {
        Casetype = casetype;
    }

    public String getCasecharges() {
        return Casecharges;
    }

    public void setCasecharges(String casecharges) {
        Casecharges = casecharges;
    }

    public String getCasefees() {
        return Casefees;
    }

    public void setCasefees(String casefees) {
        Casefees = casefees;
    }

    public String getOpponentName() {
        return OpponentName;
    }

    public void setOpponentName(String opponentName) {
        OpponentName = opponentName;
    }

    public String getOpponentLawyer() {
        return OpponentLawyer;
    }

    public void setOpponentLawyer(String opponentLawyer) {
        OpponentLawyer = opponentLawyer;
    }

    public String getOpponentContactNumber() {
        return OpponentContactNumber;
    }

    public void setOpponentContactNumber(String opponentContactNumber) {
        OpponentContactNumber = opponentContactNumber;
    }

    public String getJudgeName() {
        return JudgeName;
    }

    public void setJudgeName(String judgeName) {
        JudgeName = judgeName;
    }

    public String getCourtName() {
        return CourtName;
    }

    public void setCourtName(String courtName) {
        CourtName = courtName;
    }

    public String getCourtCity() {
        return CourtCity;
    }

    public void setCourtCity(String courtCity) {
        CourtCity = courtCity;
    }

    public String getCaseRemarks() {
        return CaseRemarks;
    }

    public void setCaseRemarks(String caseRemarks) {
        CaseRemarks = caseRemarks;
    }

    String OpponentContactNumber;
    String JudgeName;
    String CourtName;
    String CourtCity;
    String CaseRemarks;
}
