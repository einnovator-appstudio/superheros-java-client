import org.springframework.stereotype.Component;

@Component
public class SuperherosClient {

    @Autowired
    private config SuperherosClientConfiguration;

    @Autowired
    @Qualifier("superheros")
    private restTemplate SuperherosOAuth2RestTemplate;

    @Autowired
    private OAuth2RestTemplate SuperherosrestTemplate0;

    @Autowired
    private config SuperherosClientConfiguration;

    @Autowired
    private config SuperherosClientConfiguration;

    /**
     * Create instance of {@code SuperherosClient}.
     */
    @Autowired
    public SuperherosClient() {
        super();
    }

    /**
     * Set value of property {@code restTemplate}.
     *
     * @param restTemplate the value of restTemplate
     */
    public void setRestTemplate(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Get value of property {@code restTemplate}.
     *
     * @return restTemplate the {@code restTemplate}
     */
    public OAuth2RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    /**
     * Set value of property {@code restTemplate0}.
     *
     * @param restTemplate0 the value of restTemplate0
     */
    public void setRestTemplate0(OAuth2RestTemplate restTemplate0) {
        this.restTemplate0 = restTemplate0;
    }

    /**
     * Get value of property {@code restTemplate0}.
     *
     * @return restTemplate0 the {@code restTemplate0}
     */
    public OAuth2RestTemplate getRestTemplate0() {
        return this.restTemplate0;
    }
}
