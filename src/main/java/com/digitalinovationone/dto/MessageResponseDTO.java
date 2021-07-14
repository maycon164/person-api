package com.digitalinovationone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MessageResponseDTO {
	private String message;
}
