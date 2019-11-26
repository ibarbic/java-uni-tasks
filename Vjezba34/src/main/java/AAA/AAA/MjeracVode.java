package AAA.AAA;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;

public class MjeracVode {
	private List<Senzor> senzors = new ArrayList<Senzor>();

	MjeracVode(){
		
		senzors.add(Senzor_factory.generate(Senzor_factory.senzor_type.WaterTemperture));
		senzors.add(Senzor_factory.generate(Senzor_factory.senzor_type.WaterPressure));
		senzors.add(Senzor_factory.generate(Senzor_factory.senzor_type.WaterDay));
		senzors.add(Senzor_factory.generate(Senzor_factory.senzor_type.WaterYear));
		
		
	}
	
	public MjeracVode(List<Senzor> senzors) {
        this.senzors = senzors;
    } 
	public MjeracVode(Senzor s) {
		senzors.add(s);
	}
	public List<Senzor> get_senzors() {
		return senzors;
	}

	

	
	public void add_new(Senzor_factory.senzor_type type) {
		
		senzors.add(Senzor_factory.generate(type));
	}
	
	public void publish() throws InterruptedException {
		String broker = "tcp://127.0.0.1:1883";
		String clientId     = "JavaSample";
		MemoryPersistence persistence = new MemoryPersistence();
		int qos = 2;
		int j = 0;
		
		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			sampleClient.connect(connOpts);
					
			while(j != 3) {
					for(int i=0;i<senzors.size();i++){
						String topic = senzors.get(i).get_naziv();
						String content = senzors.get(i).get_value();
						System.out.println("Publishing message: "+ content);
						MqttMessage message = new MqttMessage(content.getBytes());
						message.setQos(qos);
						sampleClient.publish(topic, message);
					}
					TimeUnit.SECONDS.sleep(5);
					j++;
			}
		    
				
				sampleClient.disconnect();
				System.out.println("Disconnected");
				} 
				catch(MqttException me) {
					
		    }
				
				
	
	
	}
	}
	
	
	


