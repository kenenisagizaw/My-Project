class RegularStudent extends Student {
    public RegularStudent(String name, int id, int year, int semester, String department) {
        super(name, id, year, semester, department);
    }

    @Override
    public String getStudentType() {
        return "Regular Student";
    }
}