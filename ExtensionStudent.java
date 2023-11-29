class ExtensionStudent extends Student {
    public ExtensionStudent(String name, int id, int year, int semester, String department) {
        super(name, id, year, semester, department);
    }

    @Override
    public String getStudentType() {
        return "Extension Student";
    }
}