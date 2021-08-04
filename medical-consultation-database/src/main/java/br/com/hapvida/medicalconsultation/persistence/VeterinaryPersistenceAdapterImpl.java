package br.com.hapvida.medicalconsultation.persistence;

import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.entity.VeterinaryEntity;
import br.com.hapvida.medicalconsultation.mapper.VeterinaryEntityMapper;
import br.com.hapvida.medicalconsultation.ports.persistence.VeterinaryPersistence;
import br.com.hapvida.medicalconsultation.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class VeterinaryPersistenceAdapterImpl implements VeterinaryPersistence {

    @Autowired
    private VeterinaryRepository repository;

    @Override
    public Veterinary get(Integer id) {
        Optional<VeterinaryEntity> result = this.repository.findByIdAndDeletedAtNull(id);
        if (result.isPresent()) {
            return VeterinaryEntityMapper.INSTANCE.from(result.get());
        }

        throw new EntityNotFoundException("O veterinário de código " + id + " não foi encontrado");
    }

    @Override
    public List<Veterinary> list() {
        List<VeterinaryEntity> veterinarians = this.repository.findByDeletedAtNull();
        return VeterinaryEntityMapper.INSTANCE.from(veterinarians);
    }

    @Override
    public List<Veterinary> listOnlyTrashed() {
        List<VeterinaryEntity> veterinarians =  this.repository.findByDeletedAtNotNull();

        return VeterinaryEntityMapper.INSTANCE.from(veterinarians);
    }

    @Override
    public List<Veterinary> listWithTrashed() {
        List<Veterinary> veterinarians = this.list();
        veterinarians.addAll(this.listOnlyTrashed());

        return veterinarians;
    }

    @Override
    public Veterinary save(Veterinary veterinary) {
        VeterinaryEntity veterinaryEntity = VeterinaryEntityMapper.INSTANCE.from(veterinary);
        veterinaryEntity = this.repository.save(veterinaryEntity);
        return VeterinaryEntityMapper.INSTANCE.from(veterinaryEntity);
    }

    @Override
    public void delete(Veterinary veterinary) {
        this.repository.deleteById(veterinary.getId());
    }

    @Override
    public void active(Veterinary veterinary) {
        this.save(veterinary);
    }

    @Override
    public void inactive(Veterinary veterinary) {
        this.save(veterinary);
    }
}
