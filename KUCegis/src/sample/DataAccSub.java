package sample;

public class DataAccSub {
    private String user;
    private PassColorSub zero;
    private PassColorSub calI;
    private PassColorSub fundPCon;
    private PassColorSub intro;
    private PassColorSub digital;
    private PassColorSub knowledge;
    private PassColorSub language1;
    private PassColorSub thai;

    private PassColorSub calII;
    private PassColorSub comPro;
    private PassColorSub FundofCom;
    private PassColorSub gym;
    private PassColorSub entrepreneurship;
    private PassColorSub thaicitizens;
    private PassColorSub aesthetics;

    private PassColorSub linear;
    private PassColorSub softwareCon;
    private PassColorSub data;
    private PassColorSub stat;
    private PassColorSub iTComputer;
    private PassColorSub happy;
    private PassColorSub science1;

    private PassColorSub database;
    private PassColorSub algorithms;
    private PassColorSub assembly;
    private PassColorSub majorElectivesI;
    private PassColorSub language2;
    private PassColorSub science2;

    private PassColorSub systemAnalysis;
    private PassColorSub os;
    private PassColorSub intellectualProp;
    private PassColorSub seminar1;
    private PassColorSub majorElectivesII;
    private PassColorSub language3;

    private PassColorSub security;
    private PassColorSub automata;
    private PassColorSub compiler;
    private PassColorSub cloudComputing;
    private PassColorSub coop;
    private PassColorSub majorElectivesIII;
    private PassColorSub freeElectivesI;

    private PassColorSub coopEducation;

    private PassColorSub csProject;
    private PassColorSub majorElectivesIV;
    private PassColorSub majorElectivesV;
    private PassColorSub majorElectivesVI;
    private PassColorSub freeElectivesII;

    public String getUser() {
        return user;
    }

    public PassColorSub getSub(int index) {
        switch (index) {
            case 0:
                return zero;
            case 1:
                return calI;
            case 2:
                return fundPCon;
            case 3:
                return intro;
            case 4:
                return digital;
            case 5:
                return knowledge;
            case 6:
                return language1;
            case 7:
                return thai;
            case 8:
                return calII;
            case 9:
                return comPro;
            case 10:
                return FundofCom;
            case 11:
                return gym;
            case 12:
                return entrepreneurship;
            case 13:
                return thaicitizens;
            case 14:
                return aesthetics;
            case 15:
                return linear;
            case 16:
                return softwareCon;
            case 17:
                return data;
            case 18:
                return stat;
            case 19:
                return iTComputer;
            case 20:
                return happy;
            case 21:
                return science1;
            case 22:
                return database;
            case 23:
                return algorithms;
            case 24:
                return assembly;
            case 25:
                return majorElectivesI;
            case 26:
                return language2;
            case 27:
                return science2;
            case 28:
                return systemAnalysis;
            case 29:
                return os;
            case 30:
                return intellectualProp;
            case 31:
                return seminar1;
            case 32:
                return majorElectivesII;
            case 33:
                return language3;
            case 34:
                return security;
            case 35:
                return automata;
            case 36:
                return compiler;
            case 37:
                return cloudComputing;
            case 38:
                return coop;
            case 39:
                return majorElectivesIII;
            case 40:
                return freeElectivesI;
            case 41:
                return coopEducation;
            case 42:
                return csProject;
            case 43:
                return majorElectivesIV;
            case 44:
                return majorElectivesV;
            case 45:
                return majorElectivesVI;
            case 46:
                return freeElectivesII;
        }return null;
    }

    public DataAccSub(String user, PassColorSub zero,PassColorSub calI, PassColorSub fundPCon, PassColorSub intro,
                      PassColorSub digital, PassColorSub knowledge, PassColorSub language1,
                      PassColorSub thai, PassColorSub calII, PassColorSub comPro,
                      PassColorSub fundofCom, PassColorSub gym, PassColorSub entrepreneurship,
                      PassColorSub thaicitizens, PassColorSub aesthetics, PassColorSub linear,
                      PassColorSub softwareCon, PassColorSub data, PassColorSub stat,
                      PassColorSub iTComputer, PassColorSub happy, PassColorSub science1,
                      PassColorSub database, PassColorSub algorithms, PassColorSub assembly,
                      PassColorSub majorElectivesI, PassColorSub language2, PassColorSub science2,
                      PassColorSub systemAnalysis, PassColorSub os, PassColorSub intellectualProp,
                      PassColorSub seminar1, PassColorSub majorElectivesII, PassColorSub language3,
                      PassColorSub security, PassColorSub automata, PassColorSub compiler,
                      PassColorSub cloudComputing, PassColorSub coop, PassColorSub majorElectivesIII,
                      PassColorSub freeElectivesI, PassColorSub coopEducation, PassColorSub csProject,
                      PassColorSub majorElectivesIV, PassColorSub majorElectivesV, PassColorSub majorElectivesVI,
                      PassColorSub freeElectivesII) {

        this.user = user;
        this.zero = zero;
        this.calI = calI;
        this.fundPCon = fundPCon;
        this.intro = intro;
        this.digital = digital;
        this.knowledge = knowledge;
        this.language1 = language1;
        this.thai = thai;
        this.calII = calII;
        this.comPro = comPro;
        this.FundofCom = fundofCom;
        this.gym = gym;
        this.entrepreneurship = entrepreneurship;
        this.thaicitizens = thaicitizens;
        this.aesthetics = aesthetics;
        this.linear = linear;
        this.softwareCon = softwareCon;
        this.data = data;
        this.stat = stat;
        this.iTComputer = iTComputer;
        this.happy = happy;
        this.science1 = science1;
        this.database = database;
        this.algorithms = algorithms;
        this.assembly = assembly;
        this.majorElectivesI = majorElectivesI;
        this.language2 = language2;
        this.science2 = science2;
        this.systemAnalysis = systemAnalysis;
        this.os = os;
        this.intellectualProp = intellectualProp;
        this.seminar1 = seminar1;
        this.majorElectivesII = majorElectivesII;
        this.language3 = language3;
        this.security = security;
        this.automata = automata;
        this.compiler = compiler;
        this.cloudComputing = cloudComputing;
        this.coop = coop;
        this.majorElectivesIII = majorElectivesIII;
        this.freeElectivesI = freeElectivesI;
        this.coopEducation = coopEducation;
        this.csProject = csProject;
        this.majorElectivesIV = majorElectivesIV;
        this.majorElectivesV = majorElectivesV;
        this.majorElectivesVI = majorElectivesVI;
        this.freeElectivesII = freeElectivesII;
    }
}
