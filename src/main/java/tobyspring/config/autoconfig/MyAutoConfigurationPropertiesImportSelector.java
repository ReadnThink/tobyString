package tobyspring.config.autoconfig;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MyAutoConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> attr = importingClassMetadata.getAllAnnotationAttributes(EnableMyAutoConfigurationProperties.class.getName());
        Class propertyClass  = (Class) attr.getFirst("value");
        return new String[] { propertyClass.getName() };
    }
}
