package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ProtoTypeTest {

    @Test
    void protoBeanFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        ProtoTypeBean bean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);

        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close();



    }

    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void close(){
            System.out.println("ProtoTypeBean.close");
        }
    }
}
