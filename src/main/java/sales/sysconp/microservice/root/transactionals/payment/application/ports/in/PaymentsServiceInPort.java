package sales.sysconp.microservice.root.transactionals.payment.application.ports.in;

import sales.sysconp.microservice.root.transactionals.payment.application.dto.CreatePaymentsRequestDTO;

public interface PaymentsServiceInPort {
    void createPayments(CreatePaymentsRequestDTO request);
}