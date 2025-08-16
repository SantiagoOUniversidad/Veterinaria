package co.edu.uniquindio.veterinaria.Modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Veterinario extends Persona {
    private String especialidad;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita> listaCitasVeterinario = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Consulta> listaConsultasVeterinario = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cita> listaCitasDiaVeterinario = new ArrayList<>();




    /**
     * Metodo para crear una consulta y agregarla a la lista del veterinario
     * @param veterinaria
     * @param consulta
     * @return boolean
     */

    public boolean crearConsultas(Veterinaria veterinaria, Consulta consulta) {
        if (consulta == null) {
            return false;
        }
        listaConsultasVeterinario.add(consulta);
        veterinaria.agregarConsultaMascota(consulta);

        return true;
    }

    /**
     * Metodo para generar un String con las citas del dia de un veterinario
     * @return String
     */

    public String agendaCitasDiaVeterinario() {
        StringBuilder agenda = new StringBuilder();
        agenda.append("Citas del día para ").append(this.getNombreCompleto()).append("\n");
        for  (Cita cita : this.getListaCitasDiaVeterinario()) {
            agenda.append(cita.getIdCita()).append("\t").append(cita.getFecha()).append("\t").append(cita.getHora())
                    .append("\t").append(cita.getMascota().getNombre()).append("\n");
        }
        return agenda.toString();
    }

    /**
     * Metodo para generar un String con el historial de consultas de una mascota
     * @param mascota
     * @return String
     */

   public String historialConsultasMascota(Mascota mascota) {
        StringBuilder historialConsultasMascota = new StringBuilder();
        historialConsultasMascota.append("Historial de consultas de ").append(mascota.getNombre()).append("\n");
        for(Consulta consulta : mascota.getListaConsultasMascota()) {
            historialConsultasMascota.append(consulta.getCodigoConsulta()).append("\t")
                    .append(consulta.getMascota()).append("\t").append(consulta.getVeterinario()).append("\t")
                    .append(consulta.getDiagnostico()).append("\t").append(consulta.getTratamiento()).append("\n");
        }
        return historialConsultasMascota.toString();
   }
}
