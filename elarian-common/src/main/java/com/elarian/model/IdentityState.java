package com.elarian.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IdentityState {
    public List<Tag> tags = new ArrayList<>();
    public Map<String, DataValue> metadata = new HashMap<>();
    public List<SecondaryId> secondaryIds = new ArrayList<>();
}
