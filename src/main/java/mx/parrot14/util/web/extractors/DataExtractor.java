package mx.parrot14.util.web.extractors;

public interface DataExtractor<T> {
    public Integer getFormSize(T toExtract);
    public String extractParamData(T toExtract,String id);
}
