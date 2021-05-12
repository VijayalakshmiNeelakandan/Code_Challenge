package responseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkResponse {
    private List<Network> networks;

    public List<Network> getNetworks() {
        return networks;
    }
    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }
}
