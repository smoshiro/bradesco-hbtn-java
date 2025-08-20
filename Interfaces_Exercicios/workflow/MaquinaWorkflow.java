public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        for (var atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }
}
